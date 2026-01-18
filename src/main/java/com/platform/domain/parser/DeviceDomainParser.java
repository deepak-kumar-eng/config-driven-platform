package com.platform.domain.parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.platform.domain.model.Device;
import com.platform.domain.model.Metadata;
import com.platform.domain.model.Threshold;

public class DeviceDomainParser {

    public Device parse(File xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            Element deviceElement =
                    (Element) document.getElementsByTagNameNS("*", "Device").item(0);

            int min = Integer.parseInt(
                    deviceElement
                            .getElementsByTagNameNS("*", "MinValue")
                            .item(0)
                            .getTextContent()
            );

            int max = Integer.parseInt(
                    deviceElement
                            .getElementsByTagNameNS("*", "MaxValue")
                            .item(0)
                            .getTextContent()
            );

            String manufacturer =
                    deviceElement
                            .getElementsByTagNameNS("*", "Manufacturer")
                            .item(0)
                            .getTextContent();

            String version =
                    deviceElement
                            .getElementsByTagNameNS("*", "Version")
                            .item(0)
                            .getTextContent();

            Threshold threshold = new Threshold(min, max);
            Metadata metadata = new Metadata(manufacturer, version);

            return new Device(threshold, metadata);

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse device domain XML", e);
        }
    }
}