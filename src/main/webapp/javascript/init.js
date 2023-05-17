let listeinput = document.querySelectorAll("input");

function addlistener()
{
    //pour chaque listeinput supérieur à [3]
    //ajouter un listener qui récupère
    filteredlisteinput();
    listeinput[4].addEventListener("click",(e)=>{
        document.querySelector("input#client").value ="bonjour"
        document.querySelector("input#employe").value ="bonjour2"
    })

}

/**
 * Compare la listeinput de base avec celle une fois qui est load
 */
function filteredlisteinput() {
    // Once the document is loaded, compare the input elements
    window.addEventListener("DOMContentLoaded", (event) => {
        console.log("DOM fully loaded and parsed");

        // Initialize an array to store unique values
        let uniqueValues = [];

        // Convert NodeList to array for elementA
        let elementA = Array.from(listeinput);

        // Select input elements and convert NodeList to array for elementB
        let elementB = Array.from(document.querySelectorAll("input"));

        // Iterate over elements in elementA
        elementA.forEach(element => {
            // Check if the element is not present in elementB
            if (!elementB.includes(element) && element.type=="radio") {
                uniqueValues.push(element);
            }
        });

        // Iterate over elements in elementB
        elementB.forEach(element => {
            // Check if the element is not present in elementA
            if (!elementA.includes(element)  && element.type=="radio") {
                uniqueValues.push(element);
            }
        });

        console.log(uniqueValues);
    });
}

addlistener();