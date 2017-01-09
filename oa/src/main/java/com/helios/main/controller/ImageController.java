package com.helios.main.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.helios.main.bean.Result;

/**
 * 图片相关的控制器. 
 * 
 * @author liyu
 */
@Controller
@RequestMapping("image")
public class ImageController extends ApplicationController {
	
	private static Logger logger = Logger.getLogger(ImageController.class);
	
	/**
	 * 上传图片的界面.
	 * 
	 * 参数:
	 * path 存放upload下的二级目录
	 */
	@RequestMapping(value = "add.html")
	public ModelAndView addImage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("image/add");
		modelAndView.addObject("host", config.getImageHost());
		modelAndView.addObject("path", request.getParameter("path"));
		return modelAndView;
	}

	/**
	 * CKEditor编辑器所使用的上传图片.
	 * 
	 * 返回结果是一段js代码,详情查看方文档 http://docs.ckeditor.com/#!/guide/dev_file_upload
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload){
		response.setContentType("text/html;charset=UTF-8");
		String path = request.getParameter("path");
		String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
		StringBuffer buffer = new StringBuffer("<script type=\"text/javascript\">");
		try {
			if(StringUtils.trimToNull(path) == null){
				path = "";
			}else{
				path = path + "/";
			}
			String dir = request.getServletContext().getRealPath("upload") + "/" + path;
			String name = UUID.randomUUID().toString().replaceAll("-", "");
			boolean bol = saveFile(dir, name, upload);
			if(bol){
				String filepath = config.getImageHost() + "/" + path + name;
				buffer.append("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + filepath + "');");
			}else{
				buffer.append("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'', '文件复制失败!');");
			}
		} catch (Exception e) {
			logger.error("上传文件失败,原因:" + e.getMessage());
			buffer.append("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'', '上传失败!');");
		}
		buffer.append("</script>");
		try {
			response.getWriter().write(buffer.toString());
			response.getWriter().flush();
		} catch (IOException e) {}
	}
	/**
	 * 上传图片.
	 * 
	 * 由于使用的是MultipartFile,所以调用的页面必须是表单,并且名字必须是upload.
	 *  
	 * 示例如下:
	 * <form enctype="multipart/form-data" method="post">
	 *     <input id="upload" name="upload" type="file">
	 * </form> 
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadImage.json", method = RequestMethod.POST)
	public Result uploadImage(HttpServletRequest request, @RequestParam MultipartFile upload){
		Result result = new Result();
		String path = request.getParameter("path");
		try {
			if(StringUtils.trimToNull(path) == null){
				path = "";
			}else{
				path = path + "/";
			}
			String dir = request.getServletContext().getRealPath("upload") + "/" + path;
			String name = UUID.randomUUID().toString().replaceAll("-", "");
			boolean bol = saveFile(dir, name, upload);
			if(bol){
				String filepath = path + name;
				result.setCode(0);
				result.setMessage(filepath);
			}else{
				result.setCode(0);
				result.setMessage("复制失败!");
			}
		} catch (Exception e) {
			logger.error("上传文件失败,原因:" + e.getMessage());
			result.setCode(0);
			result.setMessage("上传失败!");
		}
		return result;
	}
	
	/**
	 * 保存文件.
	 * @param dir    文件路径
	 * @param name   文件名
	 * @param upload 上传的文件 
	 */
	private boolean saveFile(String dir, String name, MultipartFile upload){
		File target = new File(dir, name);
		target.getParentFile().mkdirs();
		try{
			Files.copy(upload.getInputStream(), target.toPath());
			return true;
		}catch(Exception e){
			logger.error("上传文件复制失败,原因:" + e.getMessage());
			return false;
		}
	}
}
