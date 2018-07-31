package com.att.training.katas.wrap;

class Wrapper {

    private final int lineLength;

    private Wrapper(int lineLength) {
        this.lineLength = lineLength;
    }

    static String wrap(String text, int lineLength) {
        return new Wrapper(lineLength).wrap(text);
    }

    private String wrap(String text) {
        var trimmedText = text.trim();
        if (fitsInOneLine(trimmedText)) {
            return trimmedText;
        }

        var endIndex = getEndIndex(trimmedText);
        return trimmedText.substring(0, endIndex)
                + "\n"
                + wrap(trimmedText.substring(endIndex));
    }

    private boolean fitsInOneLine(String trimmedText) {
        return trimmedText.length() <= lineLength;
    }

    private int getEndIndex(String trimmedText) {
        var endIndex = getNextSpaceIndex(trimmedText);
        if (noSpaceInNextLine(endIndex)) {
            endIndex = lineLength;
        }
        return endIndex;
    }

    private boolean noSpaceInNextLine(int endIndex) {
        return endIndex == -1 || endIndex > lineLength;
    }

    private int getNextSpaceIndex(String trimmedText) {
        return trimmedText.indexOf(' ');
    }
}
