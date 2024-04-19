function addBookmarkRequest() {
    const name = document.querySelector('input[name=name]').value;
    const url = document.querySelector('input[name=url]').value;
    const requestObject = {name: name, url: url};
    fetch('/bookmarks', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestObject)
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Network response was not ok.');
            }
        })
        .then(() => {
            alert("북마크 저장 완료.");
        })
        .catch(error => {
            console.error('Request failed', error);
        });
    return false;
}

function getBookmarkListRequest() {
    fetch('/bookmarks')
        .then(response => { //서버로부터 응답데이터 받아서 리턴
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Network response was not ok.');
            }
        })
        .then(bookmarks => { //리턴받은 데이터를 화면의 적절한 엘리먼트 위치를 찾아 li 요소로 추가
            const bookmarkListDom = document.querySelector('#bookmark-list');
            bookmarkListDom.innerHTML = '';
            bookmarks.forEach(bookmark => {
                const liNode = document.createElement('li');
                const textNode = document.createTextNode(bookmark.name + ' - ' + bookmark.url);
                liNode.appendChild(textNode);
                bookmarkListDom.appendChild(liNode);
            });
        })
        .catch(error => {
            console.error('Request failed', error);
        });
}