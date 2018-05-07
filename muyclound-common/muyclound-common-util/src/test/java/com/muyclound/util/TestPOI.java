package com.muyclound.util;

import com.muyclound.util.excel.ExcelUtil;
import com.muyclound.util.excel.annotation.ExportField;
import com.muyclound.util.excel.annotation.ImportField;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/5/7.
 */
public class TestPOI {
  @Test
  public void testImport() {
    String path = "/var/import/yanglikai.xlsx";

    List<ImportDemo> data = ExcelUtil.read(path, ImportDemo.class);
    for (ImportDemo el : data) {
      System.out.println(el.toString());
    }
  }

  @Test
  public void testExport() {
    List<ExportDemo> data = buildData();

    String path = "/var/export/yanglikai.xlsx";
    ExcelUtil.write(path, data);
  }

  public static List<ExportDemo> buildData() {
    List<ExportDemo> data = new ArrayList<>();
    ExportDemo d1 = new ExportDemo();
    d1.setUserid("100001");
    d1.setUsername("yanglikai");

    ExportDemo d2 = new ExportDemo();
    d2.setUserid("100002");
    d2.setUsername("yanglikai");

    ExportDemo d3 = new ExportDemo();
    d3.setUserid("100003");
    d3.setUsername("yanglikai");

    ExportDemo d4 = new ExportDemo();
    d4.setUserid("100004");
    d4.setUsername("yanglikai");

    data.add(d1);
    data.add(d2);
    data.add(d3);
    data.add(d4);
    return data;
  }

  @Data
  public static class ExportDemo {
    @ExportField(index = 0, title = "用户编号", name = "userid")
    private String userid;
    @ExportField(index = 1, title = "用户名称", name = "username")
    private String username;
  }

  @Data
  public static class ImportDemo {
    @ImportField(index = 0, desc = "用户编号", name = "userid", type = String.class)
    private String userid;
    @ImportField(index = 1, desc = "用户名", name = "username", type = String.class)
    private String username;
  }
}
