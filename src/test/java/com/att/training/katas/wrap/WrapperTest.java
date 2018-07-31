package com.att.training.katas.wrap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.att.training.katas.wrap.Wrapper.wrap;
import static org.assertj.core.api.Assertions.assertThat;

class WrapperTest {

    @Nested
    @DisplayName("No wrapping is required")
    class NoWrappingRequired {

        @Test
        void whenEmptyText() {
            var wrappedText = wrap("", 1);
            assertThat(wrappedText).isEmpty();
        }

        @Test
        void whenLineLengthEqualToTextLength() {
            var text = "word";
            var wrappedText = wrap(text, text.length());
            assertThat(wrappedText).isEqualTo(text);
        }

        @Test
        void whenLineLengthLongerThanTextLength() {
            var text = "word";
            var wrappedText = wrap(text, text.length() + 1);
            assertThat(wrappedText).isEqualTo(text);
        }
    }

    @Nested
    class WhenLineLengthShorterThanTextLength {

        @Test
        void shouldWrapAtLineLength() {
            var wrappedText = wrap("abcdefghi", 3);
            assertThat(wrappedText).isEqualTo("abc\ndef\nghi");
        }

        @Test
        void andLastLineIsShortShouldWrapAtLineLength() {
            var wrappedText = wrap("abcdefgh", 3);
            assertThat(wrappedText).isEqualTo("abc\ndef\ngh");
        }
    }

    @Nested
    @DisplayName("When the text contains a space...")
    class WhenTextContainsSpace {

        @Test
        void beforeLineLengthShouldWrapAtSpace() {
            var wrappedText = wrap("ab cdefghi", 4);
            assertThat(wrappedText).isEqualTo("ab\ncdef\nghi");
        }

        @Test
        void atLineLengthShouldWrapAtSpace() {
            var wrappedText = wrap("abc defghi", 4);
            assertThat(wrappedText).isEqualTo("abc\ndefg\nhi");
        }

        @Test
        void rightAfterLineLengthShouldWrapAtSpace() {
            var wrappedText = wrap("abcd efghi", 4);
            assertThat(wrappedText).isEqualTo("abcd\nefgh\ni");
        }


        @Test
        void afterLineLengthShouldWrapAtLineLength() {
            var wrappedText = wrap("abcde fghi", 4);
            assertThat(wrappedText).isEqualTo("abcd\ne\nfghi");
        }
    }
}
