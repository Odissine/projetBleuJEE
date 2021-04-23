package com.jee.projetbleu.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestOperationMath {
  private final OperationMath operationMath = new OperationMath();

  @Test
  void addition() {
    assertEquals(3, operationMath.calculSimpleAddition(1,2));
    assertEquals(6, operationMath.calculSimpleAddition(1.5f, 4.5f));
  }
}