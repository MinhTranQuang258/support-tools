package vn.tqminh.application.common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.CharSequenceReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

	private static Logger LOG = LoggerFactory.getLogger(FileUtil.class);

	private FileUtil() {
	}

	public static String readContent(String path) {
		File file = new File(path);
		String content= "";
		try {
			content= FileUtils.readFileToString(file, Charset.defaultCharset());
			LOG.info("Reading a file from a path [{}]", path);
		} catch (IOException e) {
			LOG.error("Error while reading file's content with the path [{}]. Detail: {}", path, e);
		}
		return content;
	}
	
	public static void wirteContent(String content, String path, CharSequence charSequence) {
		File file = new File(path);
		try {
			FileUtils.write(file, charSequence, Charset.defaultCharset());
			LOG.info("Writting a file from a path [{}]", path);
		} catch (IOException e) {
			LOG.error("Error while writing file's content with the path [{}]. Detail: {}", path, e);
		}
	}
	
	public static void readFileToMap() {
		
	}

}
