package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasyStorage {

	
	String filepath = "none.txt";
	public EasyStorage(String filepath) {
		this.filepath = filepath;
	}

	public void write(String id, String message) {
		if (get(id) == null) {
			try {
				FileWriter fw = new FileWriter(filepath, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(id + "~call" + ":" + message + ";");
				bw.newLine();
				bw.close();
			} catch (Exception e) {
				System.out.println("Error: " + "Failed to write data '" + id + ":" + message + ";" + "' :: ErrorCode: "
						+ e.getMessage());
			}
		} else {
			delete(id);
			try {
				FileWriter fw = new FileWriter(filepath, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(id + "~call" + ":" + message + ";");
				bw.newLine();
				bw.close();
			} catch (Exception e) {
				System.out.println("Error: " + "Failed to write data '" + id + ":" + message + ";" + "' :: ErrorCode: "
						+ e.getMessage());
			}
		}
	}

	public void delete(String id) {
		if (get(id) != null) {
			try {
				File file = new File(filepath);
				File temp = File.createTempFile("file", ".txt", file.getParentFile());
				String charset = "UTF-8";
				String delete = id + "~call" + ":" + get(id) + ";";
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
				for (String line; (line = reader.readLine()) != null;) {
					line = line.replace(delete, "");
					writer.println(line);
				}
				reader.close();
				writer.close();
				file.delete();
				temp.renameTo(file);
			} catch (IOException e) {
				System.out.println("Error: " + "Failed to delete data '" + id + "' :: ErrorCode: " + e.getMessage());
			}
		} else {
			System.out.println("Error: " + "Failed to delete data , data does not exist!");
		}
	}

	public String get(String id) {
		try {
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			String alldata = br.readLine();
			br.close();
			List<String> datasets = new ArrayList<String>(Arrays.asList(alldata.split(";")));
			for (String data : datasets) {
				List<String> parts = new ArrayList<String>(Arrays.asList(data.split(":")));
				if (parts.contains(id + "~call")) {
					parts.remove(id + "~call");
					if (parts.size() == 1) {
						for (String returndat : parts) {
							return returndat;
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error: " + "Failed to find file when calling for the data id '" + id
					+ "' :: ErrorCode: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(
					"Error: " + "Failed to get data from id call '" + id + "' :: ErrorCode: " + e.getMessage());
		}
		return null;
	}
}

