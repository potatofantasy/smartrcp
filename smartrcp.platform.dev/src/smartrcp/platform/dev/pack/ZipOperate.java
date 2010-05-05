package smartrcp.platform.dev.pack;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

public class ZipOperate {
	private static final String sp = "\r\n";
    
	public void jar(String jarFileName, String inputFile) {
		jar(jarFileName, new File(inputFile));
	}

	private void jar(String jarFileName, File inputFile) {
		JarOutputStream out = null;
		try {
			out = new JarOutputStream(new FileOutputStream(jarFileName));
			jar(out, inputFile, "");
            out.putNextEntry(new ZipEntry("META-INF/MANIFEST.MF"));
            
            File info=new File("MANIFEST.MF");
            byte[] bts=new byte[(int)info.length()];
            
            FileInputStream in=new FileInputStream(info);
            in.read(bts);
            
            out.write(bts);
            in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void jar(JarOutputStream out, File f, String base)
			throws IOException {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new JarEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				jar(out, fl[i], base + fl[i].getName());
			}
		} else {
			System.out.println(base);
			out.putNextEntry(new JarEntry(base));

			FileInputStream in = null;
			try {
				in = new FileInputStream(f);
				int b;
				while ((b = in.read()) != -1) {
					out.write(b);
				}
			} finally {
				in.close();
			}

		}
	}

	public static void main(String[] args) throws IOException {
		new ZipOperate().jar("kk.jar", "F:/myWork/smartrcp.platform.dev/bin");
	}

}