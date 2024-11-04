import { Group, Text, Tabs, rem, Container } from '@mantine/core';
import { useDisclosure } from '@mantine/hooks';
import { Header } from './Components/Header';
import {
  IconBadge,
  IconMenu2,
  IconSubtask
} from '@tabler/icons-react';
import { TabsComponent } from './Components/TabsComponent';


function App() {
  const [opened, { toggle }] = useDisclosure();
  const iconStyle = { width: rem(12), height: rem(12) };
  return (
    <>
    <Header />
    {/* <Container> */}
      <TabsComponent />
    {/* </Container> */}
    
    </>
  );
}

export default App;
