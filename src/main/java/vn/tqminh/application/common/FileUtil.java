package vn.tqminh.application.common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

	private static Logger LOG = LoggerFactory.getLogger(FileUtil.class);

	private FileUtil() {
	}

	public static String readContent(String path) {
		File file = new File(path);
		try {
			FileUtils.readFileToString(file, Charset.defaultCharset());
		} catch (IOException e) {
			LOG.error("Error while loading file's content with path [{}]. Detail: {}", path, e);
		}
		return null;
	}

}
