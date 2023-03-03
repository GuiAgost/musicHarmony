function goTop() {
    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
}

function viewButtonScroll() {
    if (window.scrollY === 0) {
        document.querySelector('.scrollButton').style.display = 'none';
    } else {
        document.querySelector('.scrollButton').style.display = 'block';
    }
}
window.addEventListener('scroll', viewButtonScroll);