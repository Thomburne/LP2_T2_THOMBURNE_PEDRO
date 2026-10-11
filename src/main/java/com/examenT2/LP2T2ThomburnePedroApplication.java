
package com.examenT2;

import java.awt.Desktop;
import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LP2T2ThomburnePedroApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            LP2T2ThomburnePedroApplication.class,
            args
        );
    }

    @EventListener(ApplicationReadyEvent.class)
    public void abrirChrome() {

        String url = "http://localhost:8080/orden/listado";

        try {
            String chrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

            java.io.File archivoChrome = new java.io.File(chrome);

            if (!archivoChrome.exists()) {
                chrome = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
                archivoChrome = new java.io.File(chrome);
            }

            if (archivoChrome.exists()) {

                new ProcessBuilder(chrome, url).start();

                System.out.println(
                    "Abriendo Chrome: " + url
                );

            } else if (Desktop.isDesktopSupported()
                    && Desktop.getDesktop().isSupported(
                        Desktop.Action.BROWSE)) {

                Desktop.getDesktop().browse(new URI(url));

            } else {

                System.out.println(
                    "Abre manualmente: " + url
                );
            }

        } catch (Exception e) {

            System.out.println(
                "Error al abrir Chrome: " + e.getMessage()
            );
        }
    }
}
