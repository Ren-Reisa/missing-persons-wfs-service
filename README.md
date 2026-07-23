# 失联人员 WebGIS 要素服务（WFS Service for Missing Persons）

> 一个基于 Spring Boot + PostgreSQL/PostGIS + OGC WFS 2.0 标准的空间数据服务后端项目。

---

## 一、项目简介

本项目旨在将存储在 PostgreSQL/PostGIS 空间数据库中的“失联人员”点要素数据，通过符合 **OGC WFS（Web Feature Service）2.0** 规范的接口对外发布。

外部 GIS 客户端（如 QGIS、OpenLayers、ArcGIS）可通过标准 WFS 请求发现、描述并获取这些空间要素，实现失联人员数据的标准化共享与地图可视化。

---

## 二、技术栈

| 技术/框架 | 版本/说明 |
| --- | --- |
| Spring Boot | 2.7.18 |
| Java | 11 |
| Maven | 构建工具 |
| Spring Web MVC | REST/HTTP 服务 |
| MyBatis Spring Boot Starter | 2.3.1（数据持久层） |
| PostgreSQL | 关系型数据库 |
| PostGIS | 空间数据库扩展 |
| XStream | 1.4.20（Java 对象 ↔ XML 序列化） |
| OGC 标准 | WFS / GML / OWS / XSD |

---

## 三、系统架构

```
GIS 客户端 / 浏览器
       │
       ▼
  GET /wfs?REQUEST=GetCapabilities
  GET /wfs?REQUEST=DescribeFeatureType
  GET /wfs?REQUEST=GetFeature
       │
       ▼
WfsController ──► WfsServiceImpl
                    │
   ┌────────────────┼────────────────┐
   ▼                ▼                ▼
GetCapabilities DescribeFeatureType GetFeature
   │                │                │
   ▼                ▼                ▼
Capabilities   FeatureTypeSchema   SzryService
XML 响应          XSD 响应            │
                                       ▼
                                  ISzryDao
                                       │
                                       ▼
                          PostgreSQL/PostGIS（表 szry）
                                       │
                                       ▼
                          ST_X/ST_Y 提取 lon/lat
                                       │
                                       ▼
                              Szry.initGeom()
                                       │
                                       ▼
                          封装为 GML Point（EPSG:4326）
                                       │
                                       ▼
                          XStream → GML FeatureCollection
                                       │
                                       ▼
                              返回 XML 响应
```

---

## 四、核心功能

| WFS 操作 | 接口示例 | 功能说明 |
| --- | --- | --- |
| GetCapabilities | `/wfs?REQUEST=GetCapabilities` | 返回服务能力文档，说明支持的操作、要素类型、坐标系、范围框等 |
| DescribeFeatureType | `/wfs?REQUEST=DescribeFeatureType` | 返回 `szry` 要素的 XSD Schema，定义各字段数据类型 |
| GetFeature | `/wfs?REQUEST=GetFeature` | 查询全部失联人员记录，返回 GML FeatureCollection |

---

## 五、快速启动

### 5.1 环境准备

- JDK 11+
- Maven 3.6+
- PostgreSQL 12+ 并安装 PostGIS 扩展

### 5.2 创建数据库与表

```sql
CREATE DATABASE 你的数据库名;
\c 你的数据库名;
CREATE EXTENSION postgis;

CREATE TABLE szry (
    id SERIAL PRIMARY KEY,
    objectid INT,
    szry_name VARCHAR(255),
    szsj_location_text VARCHAR(500),
    szsj_time VARCHAR(50),
    szsj_miss_timestamp INT,
    szsj_miss_age INT,
    szsj_source_type VARCHAR(255),
    szsj_police_tel VARCHAR(50),
    szsj_police_name VARCHAR(100),
    szry_gender VARCHAR(10),
    szsj_missingreason VARCHAR(500),
    szsj_miss_region VARCHAR(255),
    szry_id VARCHAR(100),
    szsj_isfound VARCHAR(10),
    geom GEOMETRY(Point, 4326)
);
```

### 5.3 修改数据库配置

编辑 `src/main/resources/application.properties`：

```properties
server.port=8080
spring.datasource.url=你的数据库url
spring.datasource.username=你的用户名
spring.datasource.password=你的密码
spring.datasource.driver-class-name=org.postgresql.Driver
mybatis.type-aliases-package=org.example.你的路径

```

### 5.4 运行项目

```bash
mvn spring-boot:run
```

或双击运行 `Final2Application` 启动类。

---

## 六、接口调用示例

### 6.1 获取服务能力

```bash
curl "http://localhost:8080/wfs?REQUEST=GetCapabilities"
```

### 6.2 获取要素类型描述

```bash
curl "http://localhost:8080/wfs?REQUEST=DescribeFeatureType"
```

### 6.3 获取全部失联人员要素

```bash
curl "http://localhost:8080/wfs?REQUEST=GetFeature"
```

---

## 七、数据库表结构

| 字段 | 说明 |
| --- | --- |
| `id` | 主键 |
| `objectid` | 对象标识 |
| `szry_name` | 失联人员姓名 |
| `szsj_location_text` | 失踪地点文本 |
| `szsj_time` | 失踪时间 |
| `szsj_miss_timestamp` | 失踪时间戳 |
| `szsj_miss_age` | 失踪时年龄 |
| `szsj_source_type` | 数据来源类型 |
| `szsj_police_tel` | 接警电话 |
| `szsj_police_name` | 民警姓名 |
| `szry_gender` | 性别 |
| `szsj_missingreason` | 失踪原因 |
| `szsj_miss_region` | 失踪区域 |
| `szry_id` | 人员编号 |
| `szsj_isfound` | 是否找到 |
| `geom` | PostGIS 点几何（EPSG:4326） |

---

## 八、项目亮点

- **遵循 OGC WFS 2.0 标准**：接口与返回格式符合国际地理信息服务规范，通用性强。
- **空间数据库实践**：真实使用 PostgreSQL + PostGIS 存储、查询与解析空间几何数据。
- **纯后端标准服务**：不绑定具体前端，可被多种 GIS 客户端直接消费。
- **XML 协议封装**：使用 XStream 手动构建 Capabilities、XSD、GML 三类复杂 XML 响应，深入理解 WFS/GML 协议细节。

---

## 九、后续优化方向

1.支持 `bbox`、`filter` 等 WFS 查询参数，增强实用性。
2.补充单元测试与集成测试。
3.增加 OpenLayers / Leaflet 前端演示页面，实现地图可视化。

---


## 十、License

本项目仅用于学习交流。
