package com.umpaytester.cbewebrest.util;

import java.io.Reader;
import java.io.Writer;

public class IOUtil {
	
	public static long copy(final Reader input, final Writer output) throws Exception{
		 long count = 0;
	     int n;
	     char[] buffer = new char[1024];
	     while (-1 != (n = input.read(buffer))) {
	            output.write(buffer, 0, n);
	            count += n;
	     }
	     return count;
	}
	
}
