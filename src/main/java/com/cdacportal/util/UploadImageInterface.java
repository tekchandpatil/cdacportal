package com.cdacportal.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.cdacportal.constants.Constants;

public interface UploadImageInterface {
	
	static String renameFileName(String filename) {
		String splitFileName[]=filename.split(Constants.DOT_OPERATOR,-1);
		return filename=splitFileName[0]+"_"+DateUtilInterface.currentDate()+"."+splitFileName[1];
	}
	
	
	static byte[] uploadImage(MultipartFile file, String uploadDirectory) {
		String filename = null;
		byte [] byteImg = null;
		if (file != null) {
			try {
				filename = file.getOriginalFilename(); // to get file name
				filename = UploadImageInterface.renameFileName(filename);
				File file_c = new File(uploadDirectory);
				if (!file_c.exists()) {
					file_c.mkdir();
				}
				byte[] bytes = file.getBytes(); // to read the image in bytes
				byteImg = filename.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(uploadDirectory + File.separator + filename))); // storing
				stream.write(bytes); // write file
				stream.flush(); // empty stream
				stream.close(); // close file
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}else {
			return null;
		}
		return byteImg;
	}
	
}
