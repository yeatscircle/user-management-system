package com.hit.pojo;

public class Administrator {
    private Integer id;
    private String name;

    public Administrator() {
    }

    public Administrator(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Administration{id = " + id + ", name = " + name + "}";
    }
}
