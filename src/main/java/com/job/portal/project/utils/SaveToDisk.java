package com.job.portal.project.utils;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public class SaveToDisk {
	 public static void saveFile(MultipartFile fileToSave, Path fullPath) throws IOException {

	        fileToSave.transferTo(fullPath);

	    }

}
