
import './App.css';
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css"; 
import "primereact/resources/themes/lara-dark-indigo/theme.css";
import PrimeReact from 'primereact/api';
import Customer from './components/customer/Customer';

function App() {
  PrimeReact.ripple = true;
  PrimeReact.inputStyle = 'filled';
  PrimeReact.autoZIndex = true;
  // PrimeReact.cssTransition = false;

  return (
    <div className="App">
      <header className="App-header">
        <p>
          ....Header....
        </p>
      </header>
      <section className="App-content">
        <Customer />
      </section>
      <footer className="App-footer">
      <p>
          ..... Footer ....
        </p>

      </footer>
    </div>
  );
}

export default App;
