/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.commons;

/**
 *
 * @author AMCG_
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a>
 * @project demo-spring-boot-jasper
 * @class JasperComponent
 * @description
 * @HU_CU_REQ
 * @date 17 sep. 2021
 */
@Component
public class JasperReportManager {

    private static final String REPORT_FOLDER = "static/reportes";

    private static final String JASPER = ".jasper";

    /**
     * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy
     * Rodríguezr</a>
     * @date 17 sep. 2021
     * @description
     * @HU_CU_REQ
     * @param fileName
     * @param tipoReporte
     * @param params
     * @param ds
     * @return
     * @throws JRException
     * @throws IOException
     */
    public ByteArrayOutputStream export(String fileName, String tipoReporte, Map<String, Object> params,
            Connection con) throws JRException, IOException {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ClassPathResource resource = new ClassPathResource(REPORT_FOLDER + File.separator + fileName + JASPER);

        InputStream inputStream = resource.getInputStream();
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, con);

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        return stream;
    }

}
