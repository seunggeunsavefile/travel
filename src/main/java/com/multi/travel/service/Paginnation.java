package com.multi.travel.service;

public class Paginnation {
    private final int page;        // 현재 페이지(1-base)
    private final int size;        // 페이지 크기
    private final int total;       // 총 건수
    private final int totalPages;  // 총 페이지
    private final int block;       // 페이지 블록 크기(예: 5, 10)
    private final int startPage;   // 현재 블록 시작 페이지
    private final int endPage;     // 현재 블록 끝 페이지

    public Paginnation(int page, int size, int total, int block) {
        this.page = Math.max(1, page);
        this.size = Math.max(1, size);
        this.total = Math.max(0, total);
        this.totalPages = (int) Math.ceil((double) this.total / this.size);
        this.block = Math.max(1, block);

        int currentBlock = (int) Math.ceil((double) this.page / this.block);
        this.startPage = (currentBlock - 1) * this.block + 1;
        int ep = this.startPage + this.block - 1;
        this.endPage = Math.min(ep, Math.max(1, this.totalPages));
    }

    public int getPage() { return page; }
    public int getSize() { return size; }
    public int getTotal() { return total; }
    public int getTotalPages() { return totalPages; }
    public int getBlock() { return block; }
    public int getStartPage() { return startPage; }
    public int getEndPage() { return endPage; }

    public boolean isHasPrev() { return startPage > 1; }
    public boolean isHasNext() { return endPage < totalPages; }

    public int getPrevPage() { return Math.max(1, startPage - 1); }
    public int getNextPage() { return Math.max(1, Math.min(totalPages, endPage + 1)); }

    public int getOffset() { return (page - 1) * size; }
}
