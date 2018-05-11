package com.shiwulian.wechat.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiwulian.wechat.bean.sys.FileType;
import com.shiwulian.wechat.mapper.sys.FileTypeMapper;

@Service
public class FileTypeService {

	@Autowired
	private FileTypeMapper fileTypeMapper;

	public List<FileType> selectList(List<String> ids) {
		return fileTypeMapper.selectList(ids);
	}
}
