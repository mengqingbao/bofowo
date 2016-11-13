package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.CommentMapper;
import com.bofowo.site.model.CommentModel;
import com.bofowo.site.query.CommentQuery;
import com.bofowo.site.service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("commentService")
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper commentMapper;
	
	public List<CommentModel> fetchPage(CommentQuery query){
		return commentMapper.fetchPageList(query);
	}
	public int fetchPageCount(CommentQuery query){
		return commentMapper.fetchPageCount(query);
	}
	public CommentModel getById(long id){
		return commentMapper.getById(id);
	}
	public void del(long id){
		commentMapper.del(id);
	}
	public long insert(CommentModel comment){
		return commentMapper.insert(comment);
	}
	public long update(CommentModel comment){
		return commentMapper.update(comment);
	}
} 
