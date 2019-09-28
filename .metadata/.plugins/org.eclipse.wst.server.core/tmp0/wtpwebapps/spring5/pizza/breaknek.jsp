<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.Gson" %>
<%
    String mem_tel = request.getParameter("mem_tel");
    List<Map<String,Object>> cusList = new ArrayList<>();
    Map<String,Object> rMap = new HashMap<>();
    rMap.put("mem_name","이순신");
    rMap.put("mem_addr","서울시 마포구 공덕동");
    rMap.put("mem_tel","025559999");
    cusList.add(rMap);
    rMap = new HashMap<>();
    rMap.put("mem_name","김유신");
    rMap.put("mem_addr","서울시 영등포구 당산동");
    rMap.put("mem_tel","026669999");
    cusList.add(rMap);
    rMap = new HashMap<>();
    rMap.put("mem_name","강감찬");
    rMap.put("mem_addr","서울시 구로구 개봉동");
    rMap.put("mem_tel","027779999");
    cusList.add(rMap);

    out.clear();
    Gson g = new Gson();
    String result = g.toJson(cusList);
    out.print(result);
%>