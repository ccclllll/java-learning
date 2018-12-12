1. File
list() ; listFiles() ; delete() ;renameTo(File file) ;idFile(); isDirectory()
2. io 代表有能力产生的数据源对象以及有能力接收数据的接收端对象
    1. InputStream 将数据源转换成输入流 （源） 
    2. OutputStream 将接收者转换为输出流 （去向）
        1. 基本输入输出流：InputStream OutputStream
        2. 字节流 ByteArrayInputStream ByteArrayOutputStream
        3. 文件流 FileInputStream FileOutputStream  
        --------------------包装---------------
        4. BufferedInputStream(Output)
        5. DataInputStream 
        6. PrintStream
        7. SequenceInputStream(Output)
    3. Reader 
    4. Writer
        1. 基本 Reader Writer InputStreamReader (OutputStreamWriter) [可接受输入输出流作为构造函数参数]
        2. 文件 FileReader FileWriter
        3. 字符流 CharArrayWriter (Reader)
        4. 字符串 StringReader(Writer) 接收字符串  
        -------------------包装-----------------------------
        5. BufferedReader(Writer) (提供缓冲，有readLine newLine) 
        6. PrintWriter
3. nio (new I/O)  
nio 底层使用ByteBuffer(存储字节的缓冲器)与包含数据的通道打交道，通道要么向缓冲区写入数据，要么从缓冲区  
得到数据。
因为文件输入输出流以及RandomAccessFile是操纵的字节流，和nio底层一致，所以它们已经用nio重写过。  
