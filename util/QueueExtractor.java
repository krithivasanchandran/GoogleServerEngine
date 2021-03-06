// Copyright 2007 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.opengse.util;

/**
 * A class that endlessly extracts Runnables from
 * a RunnableQueue and runs them
 *
 * @author Mike Jennings
 */
public class QueueExtractor implements Runnable {
  private final RunnableQueue queue;

  public QueueExtractor(RunnableQueue queue) {
    this.queue = queue;
  }

  private void runUntilInterrupted() throws InterruptedException {
    while (true) {
      Runnable task = queue.remove();
      task.run();
    }
  }

  public void run() {
    try {
      runUntilInterrupted();
    } catch (InterruptedException e) { /* ok to be interrupted */ }
  }
}
