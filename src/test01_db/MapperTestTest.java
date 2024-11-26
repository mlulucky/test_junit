package main.java.test01_db;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapperTestTest {

  MapperTest mapperTest;

  @Test
  void getPagingWithSeq() {
    List<Map<String, Object>> result = mapperTest.getPagingWithSeq(1, 0, 10);
    assertNotNull(result);
    result.forEach(System.out::println);
  }
}