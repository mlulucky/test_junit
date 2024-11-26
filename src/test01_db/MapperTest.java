package main.java.test01_db;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MapperTest {
  List<Map<String, Object>> getPagingWithSeq(int seq, int offset, int limit);
}