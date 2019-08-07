package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author dongren
 * @create 2019-08-01 10:53
 */
@Service
public class SpecificationService {
    @Autowired
    private SpecGroupMapper specGroupMapper;
    @Autowired
    private SpecParamMapper specParamMapper;

    /**
     * 根据封分类id查询规格组
     * @param cid
     * @return
     */
    public List<SpecGroup> queryGroupsByCid(Long cid) {
        SpecGroup record = new SpecGroup();
        record.setCid(cid);
        return this.specGroupMapper.select(record);
    }

    /**
     * 根据条件查询规格参数列表
     *
     * @param cid
     * @param gid
     * @param generic
     * @param searching
     * @return
     */
    public List<SpecParam> queryParams(Long gid, Long cid, Boolean generic, Boolean searching) {
        SpecParam record = new SpecParam();
        record.setGroupId(gid);
        record.setCid(cid);
        record.setGeneric(generic);
        record.setSearching(searching);
        return this.specParamMapper.select(record);
    }

    /**
     * 新增规格组
     * @param group
     */
    public void andGroup(SpecGroup group) {
        this.specGroupMapper.insertSelective(group);
    }


    /**
     * 编辑规格组
     * @param group
     */
    public void editGroup(SpecGroup group) {
        this.specGroupMapper.updateByPrimaryKey(group);
    }

    /**
     * 根据主键删除规格组
     * @param id
     */
    public void delGroup(Long id) {
        Example example = new Example(SpecParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("groupId",id);
        this.specParamMapper.deleteByExample(example);
        this.specGroupMapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增规格参数
     * @param param
     */
    public void andParam(SpecParam param) {
        this.specParamMapper.insertSelective(param);
    }

    /**
     * 编辑规格参数
     * @param param
     */
    public void editParam(SpecParam param) {
        this.specParamMapper.updateByPrimaryKey(param);
    }

    /**
     * 删除规格参数
     * @param id
     */
    public void delParam(Long id) {
        this.specParamMapper.deleteByPrimaryKey(id);
    }


    /**
     * 根据分类id查询规格组列表以及规格参数列表
     * @param cid
     * @return
     */
    public List<SpecGroup> queryGroupsWithParam(Long cid) {
        List<SpecGroup> groups = this.queryGroupsByCid(cid);
        groups.forEach(group -> {
            List<SpecParam> params = this.queryParams(group.getId(), null, null, null);
            group.setParams(params);
        });
        return groups;
    }
}
