package ac.su.ajaxspringinclass.controller;

import ac.su.ajaxspringinclass.domain.Bookmark;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class BookmarkAjaxRestController {

    private List<Bookmark> bookmarks = new ArrayList<>();

//    @RequestMapping(method = RequestMethod.POST, path = "/bookmark")
    @PostMapping("/bookmarks")
    public String registerBookmark(@RequestBody Bookmark bookmark) {
        bookmarks.add(bookmark);
        return "registered";
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/bookmarks")
    @GetMapping("/bookmarks")
    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

}