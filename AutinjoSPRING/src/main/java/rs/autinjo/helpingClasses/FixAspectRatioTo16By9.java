package rs.autinjo.helpingClasses;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;

import javax.imageio.ImageIO;

public class FixAspectRatioTo16By9 {

	public static void fixAspectRatioOneFolder(String imagesFolderPath) throws Exception {

		//File directory = new File(imagesFolderPath);
		//File[] imgFolders = directory.listFiles();
		double aspectRatio = 1.7777777777777777;

		//for (File imgFolder : imgFolders) {
		//	System.out.println(imgFolder);
		File imgFolder = new File(imagesFolderPath);	
		File[] images = imgFolder.listFiles();
			for (File img : images) {
				System.out.println(img);
				BufferedImage imgExample = ImageIO.read(img);

				if ((double) imgExample.getWidth() / imgExample.getHeight() != aspectRatio) {

					if (imgExample.getWidth() > imgExample.getHeight()) {
						int newHeight = (int) (imgExample.getWidth() / aspectRatio);
						int newWidth = imgExample.getWidth();

						if (newHeight < imgExample.getHeight()) {
							newHeight = imgExample.getHeight();
							newWidth = (int) (imgExample.getHeight() * aspectRatio);

							BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

							for (int i = 0; i < imgExample.getWidth(); i++) {
								for (int j = 0; j < imgExample.getHeight(); j++) {
									image.setRGB(i + ((image.getWidth() - imgExample.getWidth()) / 2), j,
											imgExample.getRGB(i, j));

								}
							}
							System.out.println("WAS IN WIDTH > HEIGHT IF");
							ImageIO.write(image, "jpg", img);

						} else {

							BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

							for (int i = 0; i < imgExample.getWidth(); i++) {
								for (int j = 0; j < imgExample.getHeight(); j++) {
									image.setRGB(i, j + ((image.getHeight() - imgExample.getHeight()) / 2),
											imgExample.getRGB(i, j));

								}
							}
							System.out.println("WAS IN WIDTH > HEIGHT IF");
							ImageIO.write(image, "jpg", img);
						}
					}

					if (imgExample.getHeight() >= imgExample.getWidth()) {
						int newWidth = (int) (imgExample.getHeight() * aspectRatio);
						int newHeight = imgExample.getHeight();

						if (newWidth < imgExample.getWidth()) {
							newWidth = imgExample.getWidth();
							newHeight = (int) (imgExample.getWidth() / aspectRatio);

							BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

							for (int i = 0; i < imgExample.getWidth(); i++) {
								for (int j = 0; j < imgExample.getHeight(); j++) {
									image.setRGB(i, j + ((image.getHeight() - imgExample.getHeight()) / 2),
											imgExample.getRGB(i, j));

								}
							}
							ImageIO.write(image, "jpg", img);
						} else {
							BufferedImage image = new BufferedImage(newWidth, imgExample.getHeight(),
									BufferedImage.TYPE_INT_RGB);

							for (int i = 0; i < imgExample.getWidth(); i++) {
								for (int j = 0; j < imgExample.getHeight(); j++) {
									image.setRGB(i + ((image.getWidth() - imgExample.getWidth()) / 2), j,
											imgExample.getRGB(i, j));

								}
							}
							System.out.println("WAS IN HEIGHT > WIDTH IF");
							ImageIO.write(image, "jpg", img);

						}
					}
				}
			//}

		}

		//AudioClass audioClass = new AudioClass();
		//audioClass.start();

		//Thread.sleep(10000);

	}

	public static void fixAspectRatioMultipleFolders(String imagesFolderPath) throws Exception {

		File directory = new File(imagesFolderPath);
		File[] imgFolders = directory.listFiles();
		double aspectRatio = 1.7777777777777777;

		for (File imgFolder : imgFolders) {
			System.out.println(imgFolder);
			File[] images = imgFolder.listFiles();
			for (File img : images) {
				System.out.println(img);
				BufferedImage imgExample = ImageIO.read(img);

				if ((double) imgExample.getWidth() / imgExample.getHeight() != aspectRatio) {

					if (imgExample.getWidth() > imgExample.getHeight()) {
						int newHeight = (int) (imgExample.getWidth() / aspectRatio);
						int newWidth = imgExample.getWidth();

						if (newHeight < imgExample.getHeight()) {
							newHeight = imgExample.getHeight();
							newWidth = (int) (imgExample.getHeight() * aspectRatio);

							BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

							for (int i = 0; i < imgExample.getWidth(); i++) {
								for (int j = 0; j < imgExample.getHeight(); j++) {
									image.setRGB(i + ((image.getWidth() - imgExample.getWidth()) / 2), j,
											imgExample.getRGB(i, j));

								}
							}
							System.out.println("WAS IN WIDTH > HEIGHT IF");
							ImageIO.write(image, "jpg", img);

						} else {

							BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

							for (int i = 0; i < imgExample.getWidth(); i++) {
								for (int j = 0; j < imgExample.getHeight(); j++) {
									image.setRGB(i, j + ((image.getHeight() - imgExample.getHeight()) / 2),
											imgExample.getRGB(i, j));

								}
							}
							System.out.println("WAS IN WIDTH > HEIGHT IF");
							ImageIO.write(image, "jpg", img);
						}
					}

					if (imgExample.getHeight() >= imgExample.getWidth()) {
						int newWidth = (int) (imgExample.getHeight() * aspectRatio);
						int newHeight = imgExample.getHeight();

						if (newWidth < imgExample.getWidth()) {
							newWidth = imgExample.getWidth();
							newHeight = (int) (imgExample.getWidth() / aspectRatio);

							BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

							for (int i = 0; i < imgExample.getWidth(); i++) {
								for (int j = 0; j < imgExample.getHeight(); j++) {
									image.setRGB(i, j + ((image.getHeight() - imgExample.getHeight()) / 2),
											imgExample.getRGB(i, j));

								}
							}
							ImageIO.write(image, "jpg", img);
						} else {
							BufferedImage image = new BufferedImage(newWidth, imgExample.getHeight(),
									BufferedImage.TYPE_INT_RGB);

							for (int i = 0; i < imgExample.getWidth(); i++) {
								for (int j = 0; j < imgExample.getHeight(); j++) {
									image.setRGB(i + ((image.getWidth() - imgExample.getWidth()) / 2), j,
											imgExample.getRGB(i, j));

								}
							}
							System.out.println("WAS IN HEIGHT > WIDTH IF");
							ImageIO.write(image, "jpg", img);

						}
					}
				}
			}

		}

		//AudioClass audioClass = new AudioClass();
		//audioClass.start();

		//Thread.sleep(10000);

	}

	public static void main(String[] args) throws Exception {
		String allImagesPath = "C:\\Users\\Nikola\\Desktop\\Java Workspace\\Ostalo\\AutinjoSPRING\\src\\main\\webapp\\images";
		String testPath = "C:\\Users\\Nikola\\Desktop\\Java Workspace\\Ostalo\\AutinjoSPRING\\src\\main\\webapp\\images\\Hyundai-Tucson-2020-1";

		fixAspectRatioOneFolder(testPath);

	}

}