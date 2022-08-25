/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.dto.CrearCarritoDto;
import com.cine.dto.CrearTiqueteDto;
import com.cine.dto.ReporteTiqueteDTO;
import com.cine.entity.Carrito;
import com.cine.entity.Cartelera;
import com.cine.entity.Food;
import com.cine.entity.Peliculas;
import com.cine.entity.Registro;
import com.cine.entity.Tiquete;
import com.cine.service.ICarritoService;
import com.cine.service.ICarteleraService;
import com.cine.service.IFoodService;
import com.cine.service.IRegistroService;
import com.cine.service.ITiqueteService;
import com.cine.service.UserPrincipal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author AMCG_
 */
@Controller
public class TiqueteController {

    @Autowired
    private IRegistroService registroService;

    @Autowired
    private ITiqueteService tiqueteService;

    @Autowired
    private ICarritoService carritoService;

    @Autowired
    private ICarteleraService carteleraService;

    @Autowired
    private IFoodService foodService;
//
    @GetMapping("/selecciona_asientos/{cartelera_id}")
    public String asientos(@PathVariable("cartelera_id") Long carteleraId, Model model) {
        model.addAttribute("cartelera", carteleraService.getCarteleraById(carteleraId));
        return "asientos";
    }
// para agregar productos de comida 
    @GetMapping("/food/{cartelera_id}/{asiento}")
    public String food(@PathVariable("cartelera_id") Long carteleraId, @PathVariable("asiento") String asiento, Model model) {
        model.addAttribute("cartelera", carteleraService.getCarteleraById(carteleraId));
        model.addAttribute("asiento", asiento);
        List<Food> foods = foodService.getAllFood();
        List<Carrito> carrito = new ArrayList();
        Carrito prodCarrito;
        for (Food food : foods) {
            prodCarrito = new Carrito();
            prodCarrito.setNombre(food.getProducto());
            prodCarrito.setImagen(food.getImagen());
            prodCarrito.setCantidad(0);
            prodCarrito.setPrecio(food.getPrecio());
            prodCarrito.setTotal(0);

            carrito.add(prodCarrito);
        }
        CrearCarritoDto carritoDto = new CrearCarritoDto();
        carritoDto.setProductos(carrito);
        model.addAttribute("carrito", carritoDto);
        //model.addAttribute("foods", );
        return "food";
    }
//muestra el formulario de pago rellena toda la informacion para pagar 
    @GetMapping("/pago/{cartelera_id}/{asiento}")
    public String pago(@PathVariable("cartelera_id") Long carteleraId, @PathVariable("asiento") String asiento, @ModelAttribute CrearCarritoDto productos, Model model) {
        //model.addAttribute("asiento", asiento);
        //model.addAttribute("productos", productos);
        Cartelera cartelera = carteleraService.getCarteleraById(carteleraId);
        Tiquete tiquete = new Tiquete();
        CrearTiqueteDto crearTiquete = new CrearTiqueteDto();
        tiquete.setCartelera(cartelera);

        // agregar pelicula a carrito
        Carrito pelicula = new Carrito();
        pelicula.setCantidad(1);
        pelicula.setPrecio(cartelera.getPrecio());
        pelicula.setTotal(cartelera.getPrecio() * 1.0);
        pelicula.setImagen(cartelera.getPeliculas().getImagen());
        pelicula.setNombre(cartelera.getPeliculas().getPelicula());

        /// establecer el total para la orden
        double total = pelicula.getTotal();
        Carrito producto;
        Iterator<Carrito> iterador = productos.getProductos().iterator();
        while (iterador.hasNext()) {
            producto = iterador.next();
            if (producto.getCantidad() > 0) {
                producto.setTotal(producto.getCantidad() * producto.getPrecio());
                total += producto.getTotal();
            } else {
                iterador.remove();
            }
        }
        productos.getProductos().add(0, pelicula);

        tiquete.setTotal(total);
        tiquete.setAsientoC(asiento);
        tiquete.setAsientoP(asiento);
        // agregar tiquete al dto
        crearTiquete.setTiquete(tiquete);
        // agregar productos al dto
        crearTiquete.setProductos(productos.getProductos());
        model.addAttribute("tiquete", crearTiquete);
        return "Pago";
    }
//para guardar el pago con la inforamcion del formulario 
    @PostMapping("/pago/{cartelera_id}/{asiento}")
    public String hacerPago(@PathVariable("cartelera_id") Long carteleraId, @PathVariable("asiento") String asiento, @ModelAttribute CrearTiqueteDto tiqueteDto, Model model) {
        //model.addAttribute("asiento", asiento);
        //model.addAttribute("productos", productos);
        Cartelera cartelera = carteleraService.getCarteleraById(carteleraId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        /// Asignar tiquete a usuario guest si no hay sesion
        Registro registro = registroService.getRegistroById(3);
        if (authentication.isAuthenticated()) {
            Object principal = SecurityContextHolder.getContext().getAuthentication();
            /// Asignar tiquete a usuario iniciado si hay sesion
            if (principal instanceof UserPrincipal) {
                String correo = ((UserPrincipal) principal).getUsername();
                System.out.println("Correo " + correo);
                registro = registroService.findByCorreo(correo);
            }
        }

        Tiquete tiquete = tiqueteDto.getTiquete();
        tiquete.setAsientoC(asiento);
        tiquete.setAsientoP(asiento);
        tiquete.setCartelera(cartelera);
        tiquete.setRegistro(registro);

        /// Guardar codigo random para identificar el tiquete;
        String uuid = UUID.randomUUID().toString();
        tiquete.setCodigo(uuid);
        tiqueteService.saveTiquete(tiquete);

        Tiquete guardado = tiqueteService.getTiqueteByCodigo(uuid);

        Iterator<Carrito> iterador = tiqueteDto.getProductos().iterator();

        //guardar los productos
        Carrito producto;
        while (iterador.hasNext()) {
            producto = iterador.next();
            System.out.println("producto " + producto.getNombre() + " " + producto.getCantidad());
            producto.setTiquete(guardado);
            carritoService.saveCarrito(producto);
        }
        return "redirect:/pago_completado/" + uuid;
    }
//mostrar tiquete completado
    @GetMapping("/pago_completado/{codigo}")
    public String pagoCompletadp(@PathVariable("codigo") String codigo, Model model) {
        Tiquete tiquete = tiqueteService.getTiqueteByCodigo(codigo);
        System.out.println("Tiquete" + tiquete.getId());
        List<Carrito> productos = carritoService.findAllByTiqueteId(tiquete.getId());

        model.addAttribute("tiquete", tiquete);
        model.addAttribute("productos", productos);
        return "Pago_Completado";
    }
//para imprimir el tiquete en pdf
    @GetMapping(path = "/tiquete/pdf/{codigo}")
    public ResponseEntity<Resource> pdf(@PathVariable("codigo") String codigo)
            throws JRException, IOException, SQLException {
        Map<String, Object> params = new HashMap<>();
        
        params.put("codigo", codigo);
        System.out.println("Codigo "+ codigo + " "+ params.size());
        ReporteTiqueteDTO dto = tiqueteService.obtenerReporte(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = MediaType.APPLICATION_PDF;
        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }
    // ruta de admin para mostrar la lista de tiquetes
     @GetMapping("/admin/tiquetes")
    public String tiquetesAdmin(Model model) {
        model.addAttribute("titulo", "Tiquetes");
        model.addAttribute("tiquetes", tiqueteService.getAllTiquetes());
        return "administrador/tiquetes";

    }
}
