package io.github.alphahelixdev.alpary.utilities;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.github.alphahelixdev.alpary.Alpary;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;

@Getter
@EqualsAndHashCode
@ToString
public class Updater {
	
	private final JavaPlugin pluginToUpdate;
	private final String dataFolder, currentVersion, updateURL, pluginName, jarName;
	
	public Updater(JavaPlugin pluginToUpdate, int spigotID, String jarName) {
		this.pluginToUpdate = pluginToUpdate;
		this.dataFolder = pluginToUpdate.getDataFolder().getAbsolutePath();
		this.currentVersion = pluginToUpdate.getDescription().getVersion();
		this.updateURL = "https://api.spiget.org/v2/resources/" + spigotID;
		this.pluginName = pluginToUpdate.getName();
		this.jarName = jarName;
	}
	
	public boolean update() {
		if(!getLatestVersion().equalsIgnoreCase(currentVersion)) {
			String newVersion = getLatestVersion();
			
			try {
				if(!new File(pluginToUpdate.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).delete())
					Bukkit.getLogger().log(Level.WARNING, "Unable to delete the old version of " + pluginName + " (v." + currentVersion + ")");
				
				Bukkit.getPluginManager().disablePlugin(pluginToUpdate);
				
				URL url = new URL(this.updateURL + "/download");
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("User-Agent", "SpigetResourceUpdater");
				long completeFileSize = connection.getContentLength();
				
				BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
				FileOutputStream fos = new FileOutputStream(new File(dataFolder.substring(0, dataFolder.lastIndexOf("/")) + jarName + ".jar"));
				BufferedOutputStream out = new BufferedOutputStream(fos, 1024);
				
				byte[] data = new byte[1024];
				long downloadedFileSize = 0;
				int i;
				
				while((i = in.read(data, 0, 1024)) >= 0) {
					downloadedFileSize += i;
					
					int progress = (int) ((((double) downloadedFileSize) / ((double) completeFileSize)) * 100);
					
					System.out.println("Downloading " + pluginName + " to version " + newVersion + " at " + progress + " %");
					
					out.write(data, 0, i);
				}
				
				out.close();
				in.close();
				
				Bukkit.getPluginManager().loadPlugin(new File(dataFolder.substring(0, dataFolder.lastIndexOf("/")) + "/" + jarName + ".jar"));
				Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(pluginName));
				return true;
			} catch(IOException | URISyntaxException | InvalidDescriptionException | InvalidPluginException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public String getLatestVersion() {
		try {
			String latestVersion = readFrom(updateURL + "/versions/latest");
			Type type = new TypeToken<JsonObject>() {
			}.getType();
			JsonObject object = Alpary.getInstance().gson().fromJson(latestVersion, type);
			
			return object.get("name").getAsString();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	private String readFrom(String url) throws IOException {
		try(InputStream is = new URL(url).openStream()) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			
			StringBuilder sb = new StringBuilder();
			int cp;
			while((cp = rd.read()) != -1) {
				sb.append((char) cp);
			}
			return sb.toString();
		}
	}
}
