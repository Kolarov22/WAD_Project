import {Route, createBrowserRouter, createRoutesFromElements, RouterProvider} 
from 'react-router-dom'
import LandingPage from './pages/LandingPage';
import SupportPage from './pages/SupportPage';
import FeaturesPage from './pages/FeaturesPage';
import SignInPage from './pages/SignInPage';
import SignUpPage from "./pages/SignUpPage";
import PaymentPage from './pages/PaymentPage';
import PaymentConfirmedPage from './pages/PaymentConfirmedPage';
import ClientProfilePage from './pages/ClientProfilePage';
import InstructorProfilePage from './pages/InstructorProfilePage';
import InstructorDashboardPage from './pages/InstructorDashboardPage';
import AddTrainingPlanPage from './pages/AddTrainingPlanPage';
import ClientDashboardPage from './pages/ClientDashboardPage';



const router = createBrowserRouter(
  createRoutesFromElements(
    <>
      <Route index element={<LandingPage />} />
      <Route path="/support" element={<SupportPage />} />
      <Route path="/features" element={<FeaturesPage />} />
      <Route path="/signin" element={<SignInPage />} />
      <Route path="/signup" element={<SignUpPage />} />
      <Route path="/pay" element={<PaymentPage />} />
      <Route path="/pay/confirmed" element={<PaymentConfirmedPage />} />
      <Route path="/client/settings" element={<ClientProfilePage />} />
      <Route path="/instructor/settings" element={<InstructorProfilePage />} />
      <Route path="/instructor/dashboard" element={<InstructorDashboardPage />} />
      <Route path="/instructor/dashboard/add" element={<AddTrainingPlanPage />} />
      <Route path="/client/dashboard" element={<ClientDashboardPage />} />
    </>
  )
);

function App() {
  
  return <RouterProvider router={router} />;
}

export default App
