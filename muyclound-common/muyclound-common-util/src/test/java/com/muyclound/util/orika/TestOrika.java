package com.muyclound.util.orika;

import com.muyclound.util.mapper.MapperUtil;
import com.muyclound.util.orika.demo.OrikaDest;
import com.muyclound.util.orika.demo.OrikaSource;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/5/7.
 */
public class TestOrika {

  @Test
  public void test02() {
    OrikaSource source = createSource();

    OrikaDest dest = MapperUtil.map(source, OrikaDest.class);
    System.out.println(dest);
  }

  @Test
  public void test03() {
    List<OrikaSource> data = createSourceList();

    List<OrikaDest> dest = MapperUtil.map(data, OrikaDest.class);
    for (OrikaDest el : dest) {
      System.out.println(el);
    }
  }

  private static OrikaSource createSource() {
    OrikaSource source = new OrikaSource();
    source.setUserId("S10001");
    source.setUserName("S_10001");
    source.setAge(22);

    return source;
  }

  private static List<OrikaSource> createSourceList() {
    List<OrikaSource> list = new ArrayList<>();

    OrikaSource s1 = new OrikaSource();
    s1.setUserId("S10001");
    s1.setUserName("S_10001");
    s1.setAge(22);

    OrikaSource s2 = new OrikaSource();
    s2.setUserId("S10002");
    s2.setUserName("S_10002");
    s2.setAge(32);

    OrikaSource s3 = new OrikaSource();
    s3.setUserId("S10003");
    s3.setUserName("S_10003");
    s3.setAge(42);

    list.add(s1);
    list.add(s2);
    list.add(s3);

    return list;
  }
}
