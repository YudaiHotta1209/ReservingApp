package com.example.demo.service.Announcement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Announcement.Announcement;
import com.example.demo.mapper.Announcement.AnnouncementMapper;

@Service
public class AnnouncementService {

	@Autowired
	private AnnouncementMapper announcemenMapper;

	// 全件取得

	@Transactional
	public List<Announcement> findAll() {
		return announcemenMapper.findAll();
	}

	// 登録
	@Transactional
	public void insert(Announcement announcement) {
		announcemenMapper.insert(announcement);
	}

	@Transactional
	public void delete(Long id) {
		announcemenMapper.delete(id);
	}

}
