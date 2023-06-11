package com.dvm.converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController

public class ImageConvert {
	
	@GetMapping("getimage/{cover}")
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("cover") String cover){
		if(cover.equals("")|| cover!=null) {
			try {
				Path filename = Paths.get("src/main/resources/static/img/", cover);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/png"))
						.body(byArrayResource);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	public static String convertMultipartFileToString(MultipartFile image) throws IOException {
	    String originalFilename = image.getOriginalFilename();
	    String filename = StringUtils.cleanPath(originalFilename);
	    Path destinationPath = Paths.get("src/main/resources/static/img/" + image.getOriginalFilename());
	    Files.copy(image.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
	    return filename;
	}
}
