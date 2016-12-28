/*
 * SonarLint for IntelliJ IDEA
 * Copyright (C) 2015 SonarSource
 * sonarlint@sonarsource.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonarlint.intellij.analysis;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnalysisThreadFactoryTest {
  private AnalysisThreadFactory factory;

  @Before
  public void setUp() {
    factory = new AnalysisThreadFactory();
  }

  @Test
  public void check_props() {
    Thread thread = factory.newThread(() -> {
    });

    assertThat(thread.isDaemon()).isTrue();
    assertThat(thread.getName()).startsWith("SonarLintAnalysis");
    assertThat(thread.getPriority()).isEqualTo(Thread.MIN_PRIORITY);
  }
}
