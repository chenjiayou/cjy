package cn.cjy.excel.dao;

import java.util.List;

import cn.cjy.excel.entity.DockExcel;
public interface IDockDao {
	public void save(DockExcel DockExcel);
	public void delete(DockExcel DockExcel);
	public void update(DockExcel DockExcel);
	public DockExcel findById(Integer id);
	public List<DockExcel> findAll();
}
