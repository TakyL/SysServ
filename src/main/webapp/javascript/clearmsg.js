function clearerreur()
{
    if(document.getElementById("erreur").innerText=="null")document.getElementById("erreur").innerText="";
}

window.addEventListener("DOMContentLoaded", (event) => {
clearerreur();
});
