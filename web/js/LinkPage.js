/**
 * Created by timki on 31.01.2016.
 */
var planetNum = 0;

function setCircleSize(link) {
    var length = link.length;
    var planet = document.getElementsByClassName("planet");
    planet[planetNum].setAttribute("id", "planet" + planetNum);
    var planetById = document.getElementById("planet" + planetNum);

    var width = (length * 5);
    var borderRadius = width + 20;
    planetById.style.width = width + 'px';
    planetById.style.height = width + 'px';
    planetById.style.borderRadius = borderRadius + 'px';

    planetNum++;
}