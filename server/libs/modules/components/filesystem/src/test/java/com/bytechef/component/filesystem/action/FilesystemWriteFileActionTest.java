
/*
 * Copyright 2021 <your company/name>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.filesystem.action;

import com.bytechef.component.filesystem.FilesystemComponentHandlerTest;
import com.bytechef.hermes.component.Context;
import com.bytechef.hermes.component.util.MapValueUtils;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import static com.bytechef.component.filesystem.constant.FilesystemConstants.FILENAME;
import static com.bytechef.component.filesystem.constant.FilesystemConstants.FILE_ENTRY;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ivica Cardic
 */
public class FilesystemWriteFileActionTest {

    @Test
    @SuppressFBWarnings("OBL")
    public void testPerformWriteFile() throws IOException {
        Context context = Mockito.mock(Context.class);
        File file = getSampleFile();

        Mockito.when(context.getFileStream(Mockito.any(Context.FileEntry.class)))
            .thenReturn(new FileInputStream(file));

        try (MockedStatic<MapValueUtils> mockedStatic = Mockito.mockStatic(MapValueUtils.class)) {
            mockedStatic.when(() -> MapValueUtils.getRequired(
                Mockito.anyMap(), Mockito.eq(FILE_ENTRY), Mockito.eq(Context.FileEntry.class)))
                .thenReturn(Mockito.mock(Context.FileEntry.class));
            mockedStatic.when(() -> MapValueUtils.getRequiredString(Mockito.anyMap(), Mockito.eq(FILENAME)))
                .thenReturn(file.getAbsolutePath());

            assertThat(FilesystemWriteFileAction.perform(Map.of(), context))
                .hasFieldOrPropertyWithValue("bytes", 5L);
        }
    }

    private File getSampleFile() {
        return new File(FilesystemComponentHandlerTest.class
            .getClassLoader()
            .getResource("dependencies/sample.txt")
            .getFile());
    }
}
