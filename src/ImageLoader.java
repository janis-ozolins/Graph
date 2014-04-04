import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;


public class ImageLoader {
	static ImageIcon defaultIcon = new ImageIcon(ImageLoader.class.getClassLoader().getResource("ball.png")); 
	Map<String,ImageIcon> icons;
	
	public ImageLoader(){
		icons = new HashMap<String,ImageIcon>();
	}
	
	public ImageIcon loadImage(String filename){
		if(icons.get(filename) == null ){
			ImageIcon icon = new ImageIcon(filename);
			if(isImage(icon)){
				icons.put(filename, icon);
			}else{
				icons.put(filename, defaultIcon);
			}
		}
		return icons.get(filename);
	}
	
	private boolean isImage(ImageIcon icon){
		if(icon.getIconWidth() == -1 || icon.getIconHeight() == -1){
			return false;
		}
		return true;
	}

	public static ImageIcon getDefaultIcon() {
		return defaultIcon;
	}

	public static void setDefaultIcon(ImageIcon defaultIcon) {
		ImageLoader.defaultIcon = defaultIcon;
	}
}
