package Servlet;

import Dao.FileDao;
import DaoImp.FileDaoImp;
import Entity.MyFile;
import Entity.User;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/*
        *如果是打开一个已有文件，就传递一个文件id过来，
        * 如果是新建文件，则不传递。
        * 如果没有文件id，根据用户名和文件名查询文件表，判断新创建的文件名是否冲突。
        * 在文件表中插入一条信息。
        * 如果有文件id，，根据id修改修改文件表中的相关列，
        *
        *
        *
        * */
@WebServlet(name = "UpNoteServlet",value="/upNote")
public class UpNoteServlet extends HttpServlet {
    FileDao fileDao =new FileDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content ="<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"></head><body>"+request.getParameter("content")+"</body></html>";
        String username=request.getParameter("userid");
        String filename=request.getParameter("filename");
        String fileid=request.getParameter("fileid");
        System.out.println("upnote"+" fileid:"+fileid+" filename:"+filename+" content:"+content);
        boolean flag=false;


        String savePath=request.getServletContext().getRealPath("/")+"uploadFile/";
        String fathPath=savePath+username;

        if(Integer.parseInt(fileid)==0){//是新建文件
            String sql="select * from filesys where username='"+username+"';";
            List<MyFile> files=fileDao.getFileByUser(sql);

            for( MyFile file:files){//检查文件名是否冲突
                System.out.println(file.getFilename()+"检查文件冲突"+filename+".html");
                String string=filename+".html";
                if(file.getFilename().equals(string)){
                    flag=true;
                    break;
                }
            }


            File fathdir=new File(fathPath);
            if(!fathdir.exists()){
                fathdir.mkdir();
            }

            BufferedWriter writer=new BufferedWriter(new FileWriter(new File(fathPath,filename+".html")));//这里如果文件已存在，会覆盖之前的文件
            writer.write(string2Unicode(content));


            if(!flag) {
                /*在文件表中插入一行*/
                //返回的好像都是false;
                if (fileDao.insetone("insert into filesys (username,filename,size,createtime) values('" + username + "','" + filename+".html" + "','" + content.getBytes().length + "','" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "');")) {
                 /*
               这里需要想好处理方法，在客户端提示界面显示“文件上传成功”；
                */
                    System.out.println("文件上传成功");
                }
            }else{
                boolean res=fileDao.updateByFileId("update filesys set size='"+content.getBytes().length+"', createtime='"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"' where username='"+username+"' and filename='"+filename+".html"+"';");
                System.out.println(res+"打印更行结果");

                if(res){
                    System.out.println("文件上传成功");
                }
            }

            writer.close();
        }else{//修改文件
            /*
            * 修改文件，能修改文件名或者文件内容。
            * 修改文件内容，只要直接文具文件名写入文件就行，
            * 如果修改了文件名，需要先删除之前的文件，然后写入文件（
            * 实现是，提交过来文件的id，根据id得到原文
            * 件名,删除该文件，再。。。。
            * ）。
            * */
            MyFile oldfile=fileDao.getFileByFileId("select * from filesys where fileid='"+ Integer.parseInt(fileid)+"';");

            if(!oldfile.equals(filename+".html")){
                File theFile=new File(fathPath,oldfile.getFilename()+"html");
                theFile.delete();

            }

            BufferedWriter writer=new BufferedWriter(new FileWriter(new File(fathPath,filename+".html")));//这里如果文件已存在，会覆盖之前的文件
            writer.write(string2Unicode(content));
            writer.close();
            String sql ="update filesys set username='"+username+"', filename='"+filename+".html"+"', size='"+content.getBytes().length+"', createtime='"+new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date())+"' where fileid='"+oldfile.getId()+"';";
            fileDao.updateByFileId(sql);
        }

        response.sendRedirect("/showfiles");
        System.out.println(content);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static String  utf8ToNCR(String str){
        String res="";
        for (int i = 0; i < str.length(); i++) {
            res=res+"&#"+(int)str.charAt(i)+";";
        }
        return res;
    }

    public String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            if(c>127) {
                // 转换为unicode
                unicode.append("&#x" + Integer.toHexString(c));
            }else{
                unicode.append(c);
            }
        }
        return unicode.toString();
    }
}



