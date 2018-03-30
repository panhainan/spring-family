## SpringMVC学习笔记

### 一、SpringMVC数据绑定  

#### （一）[基于form表单和url传递参数方式的数据绑定](http://sixteen.site/2018/03/19/SpringMVC%E6%95%B0%E6%8D%AE%E7%BB%91%E5%AE%9A-form%E8%A1%A8%E5%8D%95%E5%92%8Curl%E5%BD%A2%E5%BC%8F%E4%BC%A0%E5%8F%82/)   

　　1. 基本数据类型  
　　2. 包装类型  
　　3. 数组类型  
　　4. 简单对象（包括简单对象包含对象，即多层级对象）  
　　5. 同属性多对象  
　　6. 集合List类型（Set类型不太兼容，Map类型需要注意键值对，二者都不太常用）
#### （二）[基于JSON格式和XML格式传递参数方式的数据绑定](http://sixteen.site/2018/03/20/SpringMVC%E6%95%B0%E6%8D%AE%E7%BB%91%E5%AE%9A-JSON%E6%A0%BC%E5%BC%8F%E5%92%8CXML%E6%A0%BC%E5%BC%8F/)
　　1. JSON格式  
　　　　1.1 简单对象  
　　　　1.2 简单对象包含对象，即多层级对象  
　　　　1.3 对象数组  
　　　　1.4 集合List类型  
　　2. XML格式  

### 二、[SpringMVC拦截器](http://sixteen.site/2018/03/30/SpringMVC%E6%8B%A6%E6%88%AA%E5%99%A8%E5%8F%8A%E9%9D%99%E6%80%81%E8%B5%84%E6%BA%90%E5%A4%84%E7%90%86%E6%96%B9%E6%B3%95/)

#### 拦截器的简介和使用配置

#### 针对静态文件放行的三种方法