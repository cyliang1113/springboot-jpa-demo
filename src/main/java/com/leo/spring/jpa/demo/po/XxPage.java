package com.leo.spring.jpa.demo.po;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class XxPage<T> {

    private Integer current;

    private Integer size;

    private Long total;

    private List<T> content;

    public XxPage() {
        current = 1;
        size = 10;
    }

    public XxPage(Integer current, Integer size) {
        this.setCurrent(current);
        this.setSize(size);
    }

    public PageRequest jpaPage(){
        PageRequest pageRequest = new PageRequest(this.current - 1, this.size);
        return pageRequest;
    }

    public PageRequest jpaPage(Sort sort){
        PageRequest pageRequest = new PageRequest(this.current - 1, this.size, sort);
        return pageRequest;
    }

    public static <E> XxPage<E> transformPage(org.springframework.data.domain.Page<E> page){
        int current = page.getNumber();
        int size = page.getSize();
        long total = page.getTotalElements();
        List<E> content = page.getContent();
        XxPage<E> selfXxPage = new XxPage<>();
        selfXxPage.setCurrent(current+1);
        selfXxPage.setSize(size);
        selfXxPage.setTotal(total);
        selfXxPage.setContent(content);
        return selfXxPage;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        if (current == null || current < 1) {
            throw new IllegalArgumentException("页码必须大于1");
        }
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        if (current == null || current < 0) {
            throw new IllegalArgumentException("每页条数必须大于0");
        }
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
