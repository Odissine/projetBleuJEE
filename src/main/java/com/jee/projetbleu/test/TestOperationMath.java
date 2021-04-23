package com.jee.projetbleu.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.jee.projetbleu.utils.OperationMath;
import org.junit.jupiter.api.Test;

class TestOperationMath {

  private final OperationMath operationMath = new OperationMath();

  @Test
  void addition() {
    assertEquals(3, operationMath.calculSimpleAddition(1,2));
    assertEquals(6, operationMath.calculSimpleAddition(1.5f, 4.5f));
  }
}