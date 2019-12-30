package io.zucchiniui.backend.shared.domain;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicInfoTest {

    private static final String KEYWORD = "keyword";

    private static final String NAME = "name";

    private static final Location LOCATION = new Location("filename", 1L);

    @Test
    public void should_create_info_with_no_arguments() throws Exception {
        // given

        // when
        final BasicInfo info = new BasicInfo(KEYWORD, NAME, LOCATION);

        // then
        assertThat(info.getKeyword()).isEqualTo(KEYWORD);
        assertThat(info.getName()).isEqualTo(NAME);
        assertThat(info.getArguments()).isEmpty();
    }

    @Test
    public void should_create_info_with_some_arguments() throws Exception {
        // given
        final List<Argument> arguments = Lists.newArrayList(
            new Argument(0, "toto"),
            new Argument(10, "tutu")
        );

        // when
        final BasicInfo info = new BasicInfo(KEYWORD, NAME, LOCATION, arguments);

        // then
        assertThat(info.getKeyword()).isEqualTo(KEYWORD);
        assertThat(info.getName()).isEqualTo(NAME);
    }

}
