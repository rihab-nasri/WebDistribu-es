package com.example.rhproject;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormationRestAPI {

    @Autowired
    private FormationService FormationService;
    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Formation> createFormation(@RequestBody Formation formation) {
        return new ResponseEntity<>(FormationService.addFormation(formation), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Formation> updateFormation(@PathVariable(value = "id") int id, @RequestBody Formation formation)
    {
        return new ResponseEntity<>(FormationService.updateFormation(id, formation), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteFormation(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(FormationService.deleteFormation(id), HttpStatus.OK);
    }

    @GetMapping(value = "/formations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Formation> getFormation() {
        List<Formation> listFormation = FormationService.getAllFormation();
        return listFormation ;
    }
    @GetMapping("/generateQR/{formationId}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable Integer formationId) throws Exception {
        // Assurez-vous que vous avez une méthode dans qrCodeService pour générer le contenu du code QR pour la livraison.
        String qrContent = qrCodeService.generateQRCode(formationId);

        if (qrContent == null) {
            throw new Exception("Delivery not found.");
        }

        // Générez le code QR en utilisant le contenu pertinent.
        byte[] qrCodeBytes = QRCode.from(qrContent).to(ImageType.PNG).stream().toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(qrCodeBytes.length);

        return new ResponseEntity<>(qrCodeBytes, headers, HttpStatus.OK);
    }



}
