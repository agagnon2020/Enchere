
let isVisible = false;
console.log(isVisible);

document.querySelector('.close_popup').addEventListener("click", maFonctionToggle());

function maFonctionToggle()
{
    isVisible = ! isVisible;
    isVisible ? document.querySelector('#myModal').classList.add('toggle-active') : document.querySelector('#myModal').classList.remove('toggle-active');
}