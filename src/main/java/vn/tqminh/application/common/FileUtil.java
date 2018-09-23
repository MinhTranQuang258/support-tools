package vn.tqminh.application.common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

	private static Logger LOG = LoggerFactory.getLogger(FileUtil.class);

	private FileUtil() {
	}

	public static String readContent(String path) {
		File file = new File(path);
		String content = "";
		try {
			content = FileUtils.readFileToString(file, Charset.defaultCharset());
			LOG.info("Reading a file from a path [{}]", path);
		} catch (IOException e) {
			LOG.error("Error while reading file's content with the path [{}]. Detail: {}", path, e);
		}
		return content;
	}
	
	public static List<String> readLine(String path) {
		File file = new File(path);
		List<String> content= new ArrayList<>();
		try {
			content = FileUtils.readLines(file, Charset.defaultCharset());
			LOG.info("Reading lines from a path [{}]", path);
		} catch (IOException e) {
			LOG.error("Error while reading lines with the path [{}]. Detail: {}", path, e);
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

	public static List<File> readFiles(String path, String[] extensions) {
		File directory = new File(path);
		List<File> files = (List<File>) FileUtils.listFiles(directory, extensions, true);
		if(files != null) {
			return files;
		}
		return new ArrayList<>();
	}

	public static List<String> readAndIgnoreContent(String path, String ignorePath) {
		List<String> list= readLine(path);
		Set<String> ignoreSet= new HashSet<>(readLine(ignorePath));
		for (String element : list) {
			if(ignoreSet.contains(element)) {
				list.remove(element);
			}
			else {
				continue;
			}
		}
		return list;
	}
	
	public static List<String> readContentByList(String path, String providedPath) {
		List<String> list= readLine(path);
		Set<String> providedSet= new HashSet<>(readLine(providedPath));
		for (String element : list) {
			if(providedSet.contains(element)) {
				continue;
			}
			else {
				list.remove(element);
			}
		}
		return list;
	}

	public static Map<String, String> readFileToMap(String path) {
		return null;
	}

}
