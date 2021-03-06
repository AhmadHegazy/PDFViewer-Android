package com.smartmobilefactory.pdfviewer.pdfviewer.decoding;

import java.util.List;

import com.smartmobilefactory.pdfviewer.pdfviewer.page.PageLink;

public abstract class AbstractCodecDocument implements CodecDocument {

    protected final CodecContext context;

    protected final long documentHandle;

    protected AbstractCodecDocument(final CodecContext context, long documentHandle) {
        this.context = context;
        this.documentHandle = documentHandle;
    }

    @Override
    protected final void finalize() throws Throwable {
        recycle();
        super.finalize();
    }

    @Override
    public List<PageLink> getPageLinks(final int pageNuber) {
        return null;
    }

    @Override
    public List<OutlineLink> getOutline() {
        return null;
    }

    @Override
    public CodecPageInfo getPageInfo(final int pageIndex) {
        return null;
    }

    @Override
    public final void recycle() {
        if (isRecycled()) {
            context.recycle();
            freeDocument();
        }
    }

    @Override
    public final boolean isRecycled() {
        return context.isRecycled();
    }

    protected void freeDocument() {
    }
}
